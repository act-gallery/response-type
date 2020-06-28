package demo.resp_type;

import act.apidoc.SampleData;
import act.app.ActionContext;
import act.cli.Command;
import act.controller.annotation.TemplateContext;
import act.inject.param.NoBind;
import act.util.PropertySpec;
import org.osgl.inject.annotation.LoadCollection;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.util.C;
import org.osgl.util.N;
import org.osgl.xls.ExcelReader;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.io.File;
import java.util.List;

// By using `@TemplateContext` we make it easy to specify where to locate
// the template file to render the response.
// If the template context is not specified, then the default template dir
// will be <package-names>/<ClassName>, e.g. for this specific `EmployeeService`
// class, the default template context is
// `{template-root}/demo/resp_type/EmployeeService`, where the `{template-root}`
// is the template engine id, e.g. `rythm`, `excel` which is used in this
// application.
@TemplateContext("/")
@Singleton
public class EmployeeService {

    @NoBind
    private List<Employee> employees;

    @PostConstruct
    public void loadSampleData() {
        employees = SampleData.generateList(Employee.class, 57);
    }

    @GetAction
    public List<Employee> home() {
        return employees;
    }

    @GetAction("template")
    public List<Employee> template(ActionContext context) {
        // we need to manually set the download file name here
        // otherwise it will be default to `template.xxx`
        context.downloadFileName("employees");
        return employees;
    }

    @Command(value = "employees", help = "list all employees")
    @GetAction("/employees")
    @PropertySpec("id, firstName, lastName, grade, level")
    public List<Employee> employees() {
        return employees;
    }

}
