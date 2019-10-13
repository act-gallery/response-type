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

import act.annotations.Label;
import act.data.annotation.Data;

@Data
public class Employee {

    enum Grade {
        E06, E07, E08, E09, E10, E11
    }

    @Label("工号")
    public String id;

    @Label("名")
    public String firstName;

    @Label("姓")
    public String lastName;

    @Label("级别")
    public Grade grade;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
