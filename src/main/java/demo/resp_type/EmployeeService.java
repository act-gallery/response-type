package demo.resp_type;

import act.app.ActionContext;
import act.cli.Command;
import act.controller.annotation.TemplateContext;
import act.util.PropertySpec;
import org.osgl.inject.annotation.LoadCollection;
import org.osgl.mvc.annotation.GetAction;

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
public class EmployeeService {

    @LoadCollection(TestDataGenerator.class)
    private List<Employee> employees;

    @GetAction("template")
    public List<Employee> template(ActionContext context) {
        // we need to manually set the download file name here
        // otherwise it will be default to `template.xxx`
        context.downloadFileName("employees");
        return employees;
    }

    @GetAction
    @PropertySpec(cli = "id, firstName, lastName, grade")
    @Command(value = "employees", help = "list all employees")
    public List<Employee> employees() {
        return employees;
    }

}
