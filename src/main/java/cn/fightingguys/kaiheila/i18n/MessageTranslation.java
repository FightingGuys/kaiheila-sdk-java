/*
 *    Copyright 2020 FightingGuys Team
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

package cn.fightingguys.kaiheila.i18n;

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

@Slf4j
public class MessageTranslation {

    private static boolean isUseDefaultLanguage;

    static void availableLanguage() {
        Locale localLocale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", localLocale);
        if (resourceBundle.getLocale().getDisplayLanguage().length() == 0) {
            log.warn("Not supported default language, '{}_{}_{}.properties': No such file or directory",
                    resourceBundle.getBaseBundleName(),
                    localLocale.getLanguage(),
                    localLocale.getCountry());
            MessageTranslation.isUseDefaultLanguage = true;
        }
    }

    public static String getMessage(String key, Object... object) {
        Locale locale = Locale.getDefault();
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", locale);
        if (!resourceBundle.containsKey(key)) {
            if (MessageTranslation.isUseDefaultLanguage) {
                log.error("Translation key missing: {}.properties: {}, " +
                                "Please contact the Developer https://github.com/fightingguys/kaiheila-sdk-java/issue",
                        resourceBundle.getBaseBundleName(), key);
            } else {
                log.error("Translation key missing: {}_{}_{}.properties: {}, " +
                                "Please contact the Developer https://github.com/fightingguys/kaiheila-sdk-java/issue",
                        resourceBundle.getBaseBundleName(),
                        resourceBundle.getLocale().getLanguage(),
                        resourceBundle.getLocale().getCountry(),
                        key);
            }
            return "";
        }
        return MessageFormat.format(resourceBundle.getString(key), object);
    }

}
