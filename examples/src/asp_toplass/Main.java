/* $Id$ */

package asp_toplass;


import ibis.poolInfo.PoolInfo;

import shared.RMI_init;

class Main {

    public static void main(String[] argv) {
        try {
            PoolInfo info = new PoolInfo(null, true);

            int n = 4000;

            int rank = info.rank();

            boolean use_threads = false;
            boolean use_thread_pool = false;
            boolean print_result = false;

            int option = 0;

            Asp local = null;
            i_GlobalData global = null;
            i_Asp[] table = null;

            for (int i = 0; i < argv.length; i++) {
                if (false) {
                } else if (argv[i].equals("-threads")) {
                    use_threads = true;
                } else if (argv[i].equals("-print")) {
                    print_result = true;
                } else if (argv[i].equals("-thread-pool")) {
                    use_threads = true;
                    use_thread_pool = true;
                } else if (option == 0) {
                    n = Integer.parseInt(argv[i]);
                    option++;
                } else {
                    if (rank == 0) {
                        System.out.println("No such option: " + argv[i]);
                    }
                    System.exit(33);
                }
            }

            if (option > 1) {
                if (rank == 0) {
                    System.out.println("Usage: asp <n>");
                }
                System.exit(1);
            }

            // Start the registry.    
            RMI_init.getRegistry(info.getInetAddress(0).getHostAddress());

            if (info.rank() == 0) {
                global = new GlobalData(info);
                RMI_init.bind("GlobalData", global);
            } else {
                global = (i_GlobalData) RMI_init.lookup("//"
                        + info.getInetAddress(0).getHostAddress()
                        + "/GlobalData");
            }

            local = new Asp(global, n, use_threads, use_thread_pool,
                    print_result);
            table = global.table(local, info.rank());
            local.setTable(table);
            local.start();

            if (info.rank() == 0) {
                Thread.sleep(2000);
                // Give the other nodes a chance to exit.
                // before cleaning up the GlobalData object.
            }

            local = null;
            table = null;
            global = null;
            System.gc();

        } catch (Exception e) {
            System.out.println("Oops " + e);
            e.printStackTrace();
        }

        System.exit(0);
    }

}
