package com.zengjianxiong.corelog;

import timber.log.Timber;

public class AppLogUtils {


    private static boolean isLog = true;

    private AppLogUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static boolean isLog() {
        return isLog;
    }

    public static void setLog(boolean isLog) {
        AppLogUtils.isLog = isLog;
    }


    public static void v(Object msg) {
        if (!isLog) {
            return;
        }
        Timber.v(content2Str(msg));
    }

    public static void v(String tag, Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.tag(tag).v(content2Str(msg));
    }

    public static void v(String tag, Throwable e) {
        if (!isLog || e == null) {
            return;
        }
        Timber.tag(tag).v(e);
    }


    public static void i(Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.i(content2Str(msg));
    }

    public static void i(String tag, Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.tag(tag).i(content2Str(msg));
    }


    public static void w(Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.w(content2Str(msg));
    }

    public static void w(String tag, Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.tag(tag).w(content2Str(msg));
    }


    public static void e(Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.e(content2Str(msg));
    }

    public static void e(String tag, Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.tag(tag).e(content2Str(msg));
    }


    public static void e(Throwable e) {
        if (!isLog || e == null) {
            return;
        }
        Timber.e(e);
    }

    public static void e(String tag, Throwable e) {
        if (!isLog || e == null) {
            return;
        }
        Timber.tag(tag).e(e);
    }


    public static void d(Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.d(content2Str(msg));
    }

    public static void d(String tag, Object msg) {
        if (!isLog || msg == null) {
            return;
        }
        Timber.tag(tag).d(content2Str(msg));
    }

    private static String content2Str(Object content) {
        if (content instanceof String) {
            return content.toString();
        } else if (content instanceof Byte) {
            return content.toString();
        } else if (content instanceof Integer) {
            return content.toString();
        } else if (content instanceof Long) {
            return content.toString();
        } else if (content instanceof Double) {
            return content.toString();
        } else if (content instanceof Float) {
            return content.toString();
        } else if (content instanceof Short) {
            return content.toString();
        } else {
            return (content.toString());
        }
    }

}