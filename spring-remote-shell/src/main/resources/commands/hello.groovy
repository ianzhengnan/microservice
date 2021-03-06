package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

class hello {

    @Usage("Say Hello")
    @Command
    def main(InvocationContext context) {
        def bootVersion = context.attributes['spring.boot.version']
        def springVersion = context.attributes['spring.version']
        return "Hello, your spring boot version is " + bootVersion +
                ", your spring framework version is " + springVersion
    }
}
