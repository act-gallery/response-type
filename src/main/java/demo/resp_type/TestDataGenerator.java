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
import act.apidoc.sampledata.FirstNameProvider;
import act.apidoc.sampledata.LastNameProvider;
import org.osgl.$;
import org.osgl.inject.BeanSpec;
import org.osgl.inject.Genie;
import org.osgl.inject.loader.ElementLoaderBase;
import org.osgl.util.N;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TestDataGenerator extends ElementLoaderBase<Employee> {

    @Inject
    private FirstNameProvider firstNameProvider;

    @Inject
    private LastNameProvider lastNameProvider;

    private List<Employee> testData;

    @Override
    public Iterable<Employee> load(Map<String, Object> map, BeanSpec beanSpec, Genie genie) {
        return testData;
    }

    @Override
    public $.Function<Employee, Boolean> filter(Map<String, Object> map, BeanSpec beanSpec) {
        return $.F.yes();
    }

    @PostConstruct
    private void generateTestData() {
        testData = new ArrayList<>();
        for (int i = 0; i < 10 + N.randInt(30); ++i) {
            testData.add(generateRandomEmployee());
        }
    }

    private Employee generateRandomEmployee() {
        Employee employee = new Employee();
        employee.id = Act.cuid();
        employee.firstName = firstNameProvider.get();
        employee.lastName = lastNameProvider.get();
        employee.grade = $.random(Employee.Grade.class);
        return employee;
    }

}
