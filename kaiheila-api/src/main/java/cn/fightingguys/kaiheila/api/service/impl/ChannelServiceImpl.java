//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.ChannelMessageAction;
//import cn.fightingguys.kaiheila.api.domain.ChannelRoleAction;
//import cn.fightingguys.kaiheila.api.domain.ChannelRolesInfo;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.ChannelService;
//import okhttp3.OkHttpClient;
//
//public class ChannelServiceImpl implements ChannelService {
//
//    public static final String CHANNEL_SERVICE_IMPL_URL = "v3/channel";
//    public static final String SEND_MESSAGE_TO_CHANNEL_URL = CHANNEL_SERVICE_IMPL_URL + "/message";
//    public static final String LIST_CHANNEL_ROLE_URL = CHANNEL_SERVICE_IMPL_URL + "-role/index";
//    public static final String CREATE_CHANNEL_ROLE_URL = CHANNEL_SERVICE_IMPL_URL + "-role/create";
//    public static final String UPDATE_CHANNEL_ROLE_URL = CHANNEL_SERVICE_IMPL_URL + "-role/update";
//    public static final String DELETE_CHANNEL_ROLE_URL = CHANNEL_SERVICE_IMPL_URL + "-role/delete";
//
//
//    private final RequestTemplate requestTemplate;
//
//    public ChannelServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 发送消息到某个频道
//     */
//    @Deprecated
//    public ChannelMessageAction message() throws KHLAPIServiceException {
//        String url = SEND_MESSAGE_TO_CHANNEL_URL;
//        return null;
//    }
//
//    /**
//     * 列出某个频道用户角色
//     */
//    public ChannelRolesInfo listChannelRole() throws KHLAPIServiceException {
//        String url = LIST_CHANNEL_ROLE_URL;
//        return null;
//    }
//
//    /**
//     * 新建某个频道用户角色
//     */
//    public void createChannelRole() throws KHLAPIServiceException {
//        String url = CREATE_CHANNEL_ROLE_URL;
//    }
//
//    /**
//     * 更新某个频道用户角色
//     */
//    public ChannelRoleAction updateChannelRole() throws KHLAPIServiceException {
//        String url = UPDATE_CHANNEL_ROLE_URL;
//        return null;
//    }
//
//    /**
//     * 删除某个频道用户角色
//     */
//    public void deleteChannelRole() throws KHLAPIServiceException {
//        String url = DELETE_CHANNEL_ROLE_URL;
//    }
//}
