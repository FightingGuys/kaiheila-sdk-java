//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.GuildEmojiInfo;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.GuildEmoji;
//import okhttp3.OkHttpClient;
//
//import java.util.List;
//
//public class GuildEmojiImpl implements GuildEmoji {
//
//    public static final String GUILD_EMOJI_URL = "v3/guild-emoji";
//    public static final String LIST_GUILD_EMOJI_URL = GUILD_EMOJI_URL + "/index";
//    public static final String CREATE_GUILD_EMOJI_URL = GUILD_EMOJI_URL + "/create";
//    public static final String UPDATE_GUILD_EMOJI_URL = GUILD_EMOJI_URL + "/update";
//    public static final String DELETE_GUILD_EMOJI_URL = GUILD_EMOJI_URL + "/delete";
//    private final RequestTemplate requestTemplate;
//
//    public GuildEmojiImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 获取服务器表情列表
//     *
//     * @return
//     */
//    public List<GuildEmojiInfo> listGuildEmoji() throws KHLAPIServiceException {
//        String url = LIST_GUILD_EMOJI_URL;
//        return null;
//    }
//
//    /**
//     * 创建服务器表情
//     *
//     * @return
//     */
//    public GuildEmojiInfo createGuildEmoji() throws KHLAPIServiceException {
//        String url = CREATE_GUILD_EMOJI_URL;
//        return null;
//    }
//
//    /**
//     * 更新服务器表情
//     */
//    public void updateGuildEmoji() throws KHLAPIServiceException {
//        String url = UPDATE_GUILD_EMOJI_URL;
//    }
//
//    /**
//     * 删除服务器表情
//     */
//    public void deleteGuildEmoji() throws KHLAPIServiceException {
//        String url = DELETE_GUILD_EMOJI_URL;
//    }
//}
