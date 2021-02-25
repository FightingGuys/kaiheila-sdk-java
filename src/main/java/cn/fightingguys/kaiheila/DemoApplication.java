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

package cn.fightingguys.kaiheila;

import cn.fightingguys.kaiheila.kernel.config.KConfiguration;
import cn.fightingguys.kaiheila.kernel.kevent.KEventHandle;
import cn.fightingguys.kaiheila.kernel.kevent.KEventListener;
import cn.fightingguys.kaiheila.kernel.kevent.entity.KEventEntity;
import cn.fightingguys.kaiheila.kernel.kevent.entity.KEventMessageEntity;
import cn.fightingguys.kaiheila.kernel.kevent.entity.KEventUnknownTypeEntity;
import cn.fightingguys.kaiheila.kernel.kevent.entity.KEventWebhookChallengeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
public class DemoApplication implements KEventListener {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public String apply(KEventEntity event) {
        if (event instanceof KEventWebhookChallengeEntity) {
            return "{\"challenge\":\"" + ((KEventWebhookChallengeEntity) event).getChallenge() + "\"}";
        } else if (event instanceof KEventMessageEntity) {
            // 输出所有信息
            KEventMessageEntity messageEntity = (KEventMessageEntity) event;
            Instant instant = Instant.ofEpochMilli(messageEntity.getMsgTimestamp());
            LocalDateTime time = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            System.out.println(
                    time + " - " + messageEntity.getExtra().getAuthor().getNickname() + " Say: " + messageEntity.getContent()
            );
        } else if (event instanceof KEventUnknownTypeEntity) {
            ((KEventUnknownTypeEntity) event).getObjectMap().entrySet().forEach(System.out::println);
        }
        return null;
    }

    @Bean
    public KEventHandle configuration() {
        KConfiguration configuration = new KConfiguration.WebhookBuilder()
                .clientId("EkMs3pIffDvaZfJ_")
                .clientSecret("1bqSfY132dKzskdq")
                .token("1/MTAwMTE=/atBiDhVz330+XHbswXLvbQ==")
                .verifyToken("oPpYddCNPr1m8VgB")
                .encryptKey("kVm3QqTNpAauPlg")
                .build();
        return new KEventHandle(configuration, new DemoApplication());
    }
}
