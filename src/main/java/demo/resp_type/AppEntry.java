package demo.resp_type;

/*-
 * #%L
 * actframework app demo - excel
 * %%
 * Copyright (C) 2018 ActFramework
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import act.Act;
import act.cli.Command;
import act.job.Cron;
import org.osgl.mvc.annotation.GetAction;
import osgl.version.Version;
import osgl.version.Versioned;

/**
 * A sample application demonstrate how to generate Excel/csv report in Act
 */
@SuppressWarnings("unused")
@Versioned
public class AppEntry {

    public static final Version VERSION = Version.get();

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
