package vn.woodsland.byserp.web.constant;

public class Router {

    public static final String CONTEXT_ROOT = "/";

    public interface COMMON {
        String MODULE = "cmn";

        interface CMN0001 {

            String ID = MODULE + "/cmn0001";

            interface URI {
                String ROOT = CONTEXT_ROOT + ID;

                String INIT = ROOT + "/init";
            }

            interface VIEW {
                String INIT = ID;
            }
        }

        interface CMN0002 {
            String ID = MODULE + "/cmn0002";

            interface URI {
                String ROOT = CONTEXT_ROOT + ID;

                String INIT = ROOT + "/init";
                String DATA_USER = ROOT + "/data-user";
                String SEARCH = ROOT + "/search";
                String UPDATE_BRANCH = ROOT + "/update-branch/{id}";
                String LOAD_DATA = ROOT + "/load-data";
            }

            interface VIEW {
                String INIT = ID;
            }
        }

        interface CMN00021 {
            String ID = MODULE + "/cmn00021";

            interface URI {
                String ROOT = CONTEXT_ROOT + ID;

                String INIT = ROOT + "/init";

                String UPDATE = ROOT + "/update";
            }

            interface VIEW {
                String INIT = ID;
            }
        }

        interface CMN0004 {
            String ID = MODULE + "/cmn0004";

            interface URI {
                String ROOT = CONTEXT_ROOT + ID;

                String INIT = ROOT + "/init";

                String SEARCH_USER = ROOT + "/seach-user";
            }

            interface VIEW {
                String INIT = ID;
            }
        }

        interface CMN0005 {
            String ID = MODULE + "/cmn0005";

            interface URI {
                String ROOT = CONTEXT_ROOT + ID;

                String INIT = ROOT + "/init";
                String LOAD_DATA = ROOT + "/load-data";
                String UPDATE_REQUEST_TYPE = ROOT + "/update-request-type/{id}";
            }

            interface VIEW {
                String INIT = ID;
            }
        }

        interface CMN00051 {
            String ID = MODULE + "/cmn00051";

            interface URI {
                String ROOT = CONTEXT_ROOT + ID;

                String INIT = ROOT + "/init";

                String UPDATE = ROOT + "/update";

                String BACK = ROOT + "/back";
            }

            interface VIEW {
                String INIT = ID;
            }
        }
    }

    public interface SUGGESTION {
        String MODULE = "rqt";

        interface REQUEST {
            interface RQT0001 {

                String ID = MODULE + "/rqt0001";

                interface URI {
                    String ROOT = CONTEXT_ROOT + ID;

                    String INIT = ROOT + "/init";
                    String LOAD_DATA = ROOT + "/load-data";
                }

                interface VIEW {
                    String INIT = ID;
                }
            }

            interface RQT00011 {

                String ID = MODULE + "/rqt00011";

                interface URI {
                    String ROOT = CONTEXT_ROOT + ID;

                    String INIT = ROOT + "/init";
                }

                interface VIEW {
                    String INIT = ID;
                }
            }

            interface RQT0002 {

                String ID = MODULE + "/rqt0002";

                interface URI {
                    String ROOT = CONTEXT_ROOT + ID;

                    String INIT = ROOT + "/init";
                    String LOAD_DATA = ROOT + "/load-data";
                    String UPDATE = ROOT + "/update";
                    String DELETE = ROOT + "/delete";
                }

                interface VIEW {
                    String INIT = ID;
                }
            }

            interface RQT00021 {

                String ID = MODULE + "/rqt00021";

                interface URI {
                    String ROOT = CONTEXT_ROOT + ID;

                    String INIT = ROOT + "/init";
                    String SAVE = ROOT + "/save";
                    String SEARCH_USER = ROOT + "/search-user";
                }

                interface VIEW {
                    String INIT = ID;
                }
            }

            interface RQT00022 {

                String ID = MODULE + "/rqt00022";

                interface URI {
                    String ROOT = CONTEXT_ROOT + ID;

                    String INIT = ROOT + "/init";

                    String UPDATE = ROOT + "/update";
                }

                interface VIEW {
                    String INIT = ID;
                }
            }

        }

        interface APPROVED {
            interface APR0002 {

                String ID = MODULE + "/apr0002";

                interface URI {
                    String ROOT = CONTEXT_ROOT + ID;

                    String INIT = ROOT + "/init";
                    String LOAD_DATA = ROOT + "/load-data";
                    String UPDATE_REQUEST_STATUS = ROOT + "/update-request-status";
                    String UPDATE = ROOT + "/update";
                }

                interface VIEW {
                    String INIT = ID;
                }
            }

            interface APR00021 {

                String ID = MODULE + "/apr00021";

                interface URI {
                    String ROOT = CONTEXT_ROOT + ID;

                    String INIT = ROOT + "/init";
                    String UPDATE = ROOT + "/update";
                }

                interface VIEW {
                    String INIT = ID;
                }
            }
        }
    }
}
