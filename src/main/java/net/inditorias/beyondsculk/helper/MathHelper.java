package net.inditorias.beyondsculk.helper;

import net.inditorias.beyondsculk.helper.Math.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MathHelper {
    /**
     * Draws a spline (out of blocks) between specified vectors.
     *
     * @param nodevectors The list of vectors to draw through.
     * @param tension The tension of every node.
     * @param bias The bias of every node.
     * @param continuity The continuity of every node.
     * @param quality The quality of the spline. Must be greater than 0.
     * @param radius The radius (thickness) of the spline.
     * @param filled If false, only a shell will be generated.
     *
     * @return number of blocks affected
     */
    public static Set<BlockVector3> drawSpline(List<BlockVector3> nodevectors, double tension, double bias,
                          double continuity, double quality, double radius, boolean filled)
    {

        Set<BlockVector3> vset = new HashSet<>();
        List<Node> nodes = new ArrayList<>(nodevectors.size());

        Interpolation interpol = new KochanekBartelsInterpolation();

        for (BlockVector3 nodevector : nodevectors) {
            Node n = new Node(nodevector.toVector3());
            n.setTension(tension);
            n.setBias(bias);
            n.setContinuity(continuity);
            nodes.add(n);
        }

        interpol.setNodes(nodes);
        double splinelength = interpol.arcLength(0, 1);
        for (double loop = 0; loop <= 1; loop += 1D / splinelength / quality) {
            Vector3 tipv = interpol.getPosition(loop);

            vset.add(tipv.toBlockPoint());
        }

        vset = getBallooned(vset, radius);
        if (!filled) {
            vset = getHollowed(vset);
        }
        return vset;
    }
    
    /**
     * Makes a sphere or ellipsoid.
     *
     * @param pos Center of the sphere or ellipsoid
     * @param radiusX The sphere/ellipsoid's largest north/south extent
     * @param radiusY The sphere/ellipsoid's largest up/down extent
     * @param radiusZ The sphere/ellipsoid's largest east/west extent
     * @param filled If false, only a shell will be generated.
     * @return number of blocks changed
     */
    public static Set<BlockVector3> makeSphere(BlockVector3 pos, double radiusX, double radiusY, double radiusZ, boolean filled){
        Set<BlockVector3> vset = new HashSet<>();
        radiusX += 0.5;
        radiusY += 0.5;
        radiusZ += 0.5;

        final double invRadiusX = 1 / radiusX;
        final double invRadiusY = 1 / radiusY;
        final double invRadiusZ = 1 / radiusZ;

        final int ceilRadiusX = (int) Math.ceil(radiusX);
        final int ceilRadiusY = (int) Math.ceil(radiusY);
        final int ceilRadiusZ = (int) Math.ceil(radiusZ);

        double nextXn = 0;
        forX: for (int x = 0; x <= ceilRadiusX; ++x) {
            final double xn = nextXn;
            nextXn = (x + 1) * invRadiusX;
            double nextYn = 0;
            forY: for (int y = 0; y <= ceilRadiusY; ++y) {
                final double yn = nextYn;
                nextYn = (y + 1) * invRadiusY;
                double nextZn = 0;
                forZ: for (int z = 0; z <= ceilRadiusZ; ++z) {
                    final double zn = nextZn;
                    nextZn = (z + 1) * invRadiusZ;

                    double distanceSq = lengthSq(xn, yn, zn);
                    if (distanceSq > 1) {
                        if (z == 0) {
                            if (y == 0) {
                                break forX;
                            }
                            break forY;
                        }
                        break forZ;
                    }

                    if (!filled) {
                        if (lengthSq(nextXn, yn, zn) <= 1 && lengthSq(xn, nextYn, zn) <= 1 && lengthSq(xn, yn, nextZn) <= 1) {
                            continue;
                        }
                    }
                    
                    vset.add(new BlockVector3(x, y, z));
                    vset.add(new BlockVector3(-x, y, z));
                    vset.add(new BlockVector3(x, -y, z));
                    vset.add(new BlockVector3(x, y, -z));
                    vset.add(new BlockVector3(-x, -y, z));
                    vset.add(new BlockVector3(x, -y, -z));
                    vset.add(new BlockVector3(-x, y, -z));
                    vset.add(new BlockVector3(-x, -y, -z));
                }
            }
        }

        return vset;
    }


    private static Set<BlockVector3> getBallooned(Set<BlockVector3> vset, double radius) {
        Set<BlockVector3> returnset = new HashSet<>();
        int ceilrad = (int) Math.ceil(radius);

        for (BlockVector3 v : vset) {
            int tipx = v.getBlockX();
            int tipy = v.getBlockY();
            int tipz = v.getBlockZ();

            for (int loopx = tipx - ceilrad; loopx <= tipx + ceilrad; loopx++) {
                for (int loopy = tipy - ceilrad; loopy <= tipy + ceilrad; loopy++) {
                    for (int loopz = tipz - ceilrad; loopz <= tipz + ceilrad; loopz++) {
                        if (hypot(loopx - tipx, loopy - tipy, loopz - tipz) <= radius) {
                            returnset.add(BlockVector3.at(loopx, loopy, loopz));
                        }
                    }
                }
            }
        }
        return returnset;
    }

    private static Set<BlockVector3> getHollowed(Set<BlockVector3> vset) {
        Set<BlockVector3> returnset = new HashSet<>();
        for (BlockVector3 v : vset) {
            double x = v.getX();
            double y = v.getY();
            double z = v.getZ();
            if (!(vset.contains(BlockVector3.at(x + 1, y, z))
                    && vset.contains(BlockVector3.at(x - 1, y, z))
                    && vset.contains(BlockVector3.at(x, y + 1, z))
                    && vset.contains(BlockVector3.at(x, y - 1, z))
                    && vset.contains(BlockVector3.at(x, y, z + 1))
                    && vset.contains(BlockVector3.at(x, y, z - 1)))) {
                returnset.add(v);
            }
        }
        return returnset;
    }

    private static double hypot(double... pars) {
        double sum = 0;
        for (double d : pars) {
            sum += Math.pow(d, 2);
        }
        return Math.sqrt(sum);
    }

    private static double lengthSq(double x, double y, double z) {
        return (x * x) + (y * y) + (z * z);
    }
    
}
