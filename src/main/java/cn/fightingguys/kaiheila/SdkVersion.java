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

package cn.fightingguys.kaiheila;

/**
 * 开黑啦Java开发工具包版本信息
 */
public class SdkVersion {

    /**
     * SDK软件包名称
     */
    public final static String NAME = "KaiHeiLa SDK for Java";

    /**
     * 版本号 x.y.z-sss，这属于 x
     */
    public final static short MAJOR_VERSION_NUMBER = 0;

    /**
     * 版本号 x.y.z-sss，这属于 y
     */
    public final static short MINOR_VERSION_NUMBER = 0;

    /**
     * 版本号 x.y.z-sss，这属于 z
     */
    public final static short REVISION_VERSION_NUMBER = 1;

    /**
     * 软件工程构建阶段
     * <pre>
     * ALPHA    (内测版本)
     * BETA     (公测版本)
     * NIGHTLY  (每日构建)
     * SNAPSHOT (项目快照)
     * STABLE   (稳定版本)
     * </pre>
     */
    public final static String SOFTWARE_STAGE = "ALPHA";

    /**
     * 当前软件包版本号，格式 x.y.z-sss
     */
    public final static String VERSION =
            MAJOR_VERSION_NUMBER + "." + MINOR_VERSION_NUMBER + "." + REVISION_VERSION_NUMBER + "-" + SOFTWARE_STAGE;

    /**
     * SDK工具包全名
     */
    public final static String FULL_NAME = NAME + " " + VERSION;

    /**
     * 将返回当前工具包名称
     *
     * @return 工具包名称
     */
    public static String getName() {
        return NAME;
    }

    /**
     * 版本号 x.y.z-sss，这属于 x
     *
     * @return 主版本号
     */
    public static short getMajorVersionNumber() {
        return MAJOR_VERSION_NUMBER;
    }

    /**
     * 版本号 x.y.z-sss，这属于 y
     *
     * @return 次版本号
     */
    public static short getMinorVersionNumber() {
        return MINOR_VERSION_NUMBER;
    }

    /**
     * 版本号 x.y.z-sss，这属于 z
     *
     * @return 修订版本号
     */
    public static short getRevisionVersionNumber() {
        return REVISION_VERSION_NUMBER;
    }

    /**
     * 软件工程构建阶段
     * <pre>
     * ALPHA    (内测版本)
     * BETA     (公测版本)
     * NIGHTLY  (每日构建)
     * SNAPSHOT (项目快照)
     * STABLE   (稳定版本)
     * </pre>
     *
     * @return 软件构建阶段对应信息
     */
    public static String getSoftwareStage() {
        return SOFTWARE_STAGE;
    }

    /**
     * 当前软件包版本号
     *
     * @return 格式 x.y.z-xxx
     */
    public static String getVersion() {
        return VERSION;
    }

    /**
     * SDK工具包全名
     *
     * @return 格式 software-name x.y.z-xxx
     */
    public static String getFullName() {
        return FULL_NAME;
    }

    /**
     * 版本号整数型，例如：1.1.3 版本，整数结果为 100103，此函数作为便于在测试阶段时尽早发现自己SDK使用版本问题<br/>
     * 版本号计算规则
     * <pre>
     * ReturnVersionNumber = (主版本号)MAJOR_VERSION_NUMBER * 10000
     * ReturnVersionNumber +=(子版本号)MINOR_VERSION_NUMBER * 100
     * ReturnVersionNumber += (修订版本号)REVISION_VERSION_NUMBER;
     * </pre>
     *
     * @return 整数型版本号
     */
    public static Integer getIntegerVersionNumber() {
        return MAJOR_VERSION_NUMBER * 10000 + MINOR_VERSION_NUMBER * 100 + REVISION_VERSION_NUMBER;
    }
}
