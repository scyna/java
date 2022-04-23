package io.scyna;

class Path {
    public static final String GEN_GET_ID_URL = "/scyna/generator/id";
    public static final String GEN_GET_SN_URL = "/scyna/generator/sn";
    public static final String SESSION_CREATE_URL = "/scyna/session/create";
    public static final String SESSION_UPDATE_CHANNEL = "scyna.session.update";
    public static final String SESSION_END_CHANNEL = "scyna.session.end";
    public static final String LOG_WRITE_CHANNEL = "scyna.log";
    public static final String SETTING_WRITE_URL = "/scyna/setting/write";
    public static final String SETTING_READ_URL = "/scyna/setting/read";
    public static final String SETTING_REMOVE_URL = "/scyna/setting/remove";
    public static final String SETTING_UPDATE_CHANNEL = "scyna.setting.updated.";
    public static final String SETTING_REMOVE_CHANNEL = "scyna.setting.removed.";
    public static final String CALL_WRITE_CHANNEL = "scyna.call.write";
    public static final String APP_UPDATE_CHANNEL = "scyna.application.updated";
    public static final String CLIENT_UPDATE_CHANNEL = "scyna.client.updated";
    public static final String AUTH_CREATE_URL = "/scyna/auth/create";
    public static final String AUTH_GET_URL = "/scyna/auth/get";
    public static final String AUTH_LOGOUT_URL = "/scyna/auth/logout";
}
