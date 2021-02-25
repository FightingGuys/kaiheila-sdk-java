//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.GuildEmojiInfo;
//import cn.fightingguys.kaiheila.api.domain.GuildRoleAction;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.GuildRoleService;
//import okhttp3.OkHttpClient;
//
//import java.util.List;
//
//public class GuildRoleServiceImpl implements GuildRoleService {
//
//    public static final String ROLE_SERVICE_URL = KHLRestApiService.API_ENDPOINT_BASE_URL + "v3/guild-role";
//    public static final String LIST_ROLES_BY_GUILD_URL = ROLE_SERVICE_URL + "/index";
//    public static final String CREATE_GUILD_ROLE_URL = ROLE_SERVICE_URL + "/create";
//    public static final String UPDATE_GUILD_ROLE_URL = ROLE_SERVICE_URL + "/update";
//    public static final String DELETE_GUILD_ROLE_URL = ROLE_SERVICE_URL + "/delete";
//    public static final String GRANT_USER_ROLE_URL = ROLE_SERVICE_URL + "/grant";
//    public static final String REVOKE_USER_ROLE_URL = ROLE_SERVICE_URL + "/revoke";
//
//    private final RequestTemplate requestTemplate;
//
//    public GuildRoleServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 获取服务器角色列表
//     */
//    public List<GuildEmojiInfo> listRolesByGuild() throws KHLAPIServiceException {
//        String url = LIST_ROLES_BY_GUILD_URL;
//        return null;
//    }
//
//    /**
//     * 创建服务器角色
//     */
//    public GuildEmojiInfo createGuildRole() throws KHLAPIServiceException {
//        String url = CREATE_GUILD_ROLE_URL;
//        return null;
//    }
//
//    /**
//     * 更新服务器角色
//     */
//    public GuildEmojiInfo updateGuildRole() throws KHLAPIServiceException {
//        String url = UPDATE_GUILD_ROLE_URL;
//        return null;
//    }
//
//    /**
//     * 删除服务器角色
//     */
//    public void deleteGuildRole() throws KHLAPIServiceException {
//        String url = DELETE_GUILD_ROLE_URL;
//    }
//
//    /**
//     * 赋予用户角色
//     */
//    public GuildRoleAction grantUserRole() throws KHLAPIServiceException {
//        String url = GRANT_USER_ROLE_URL;
//        return null;
//    }
//
//    /**
//     * 删除用户角色
//     */
//    public GuildRoleAction revokeUserRole() throws KHLAPIServiceException {
//        String url = REVOKE_USER_ROLE_URL;
//        return null;
//    }
//}
