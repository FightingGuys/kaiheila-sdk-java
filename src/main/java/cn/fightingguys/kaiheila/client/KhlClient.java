/*
 *    Copyright 2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package cn.fightingguys.kaiheila.client;

import cn.fightingguys.kaiheila.client.profile.KhlProfile;
import cn.fightingguys.kaiheila.client.profile.SdkProfile;
import cn.fightingguys.kaiheila.kernel.api.core.KRestCore;
import cn.fightingguys.kaiheila.kernel.event.source.KEventSource;


public class KhlClient {

    private final SdkProfile sdkProfile;

    private final KhlProfile khlProfile;

    /**
     * 事件消息处理
     */
    private KEventSource KEventSource;

    /**
     * API 核心处理
     */
    private KRestCore kRestCore;

    private KhlClient(SdkProfile sdkProfile, KhlProfile khlProfile) {
        this.sdkProfile = sdkProfile;
        this.khlProfile = khlProfile;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void start() {

    }

    public static class Builder {
        private SdkProfile sdkProfile;
        private KhlProfile khlProfile;

        public Builder sdkProfile(SdkProfile sdkProfile) {
            this.sdkProfile = sdkProfile;
            return this;
        }

        public Builder khlProfile(KhlProfile khlProfile) {
            this.khlProfile = khlProfile;
            return this;
        }

        public KhlClient create() {
            // todo logging
            assert khlProfile != null : "不能为空";
            if (sdkProfile == null) {
                sdkProfile = SdkProfile.Builder.createDefault();
            }
            return new KhlClient(sdkProfile, khlProfile);
        }

    }

}
