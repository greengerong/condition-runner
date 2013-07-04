Add Aspectj AOP for run some method by condition.

For example: In our code base, it is for mutiple brands, so some times we only want our code only release for some brands.
Then we can easy to use this plugin to mask it. And for this plugin, you can easy to defined yourself rule to support your requirement.

Usage:(you can see the sample project https://github.com/greengerong/condition-runner/tree/master/sample)

1:add depends :(will be release soon.)

       <dependency>
            <groupId>com.github.greengerong</groupId>
            <artifactId>condition-runner</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>


 2:add compiler build:

        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>aspectj-maven-plugin</artifactId>
            <version>1.4</version>
            <configuration>
                <verbose>true</verbose>
                <privateScope>true</privateScope>
                <complianceLevel>1.6</complianceLevel>
                <aspectLibraries>
                    <aspectLibrary>
                        <groupId>com.github.greengerong</groupId>
                        <artifactId>condition-runner</artifactId>
                    </aspectLibrary>
                </aspectLibraries>
            </configuration>
            <executions>
                <execution>
                    <goals>
                        <goal>compile</goal>
                        <!-- use this goal to weave all your main classes -->
                        <goal>test-compile</goal>
                        <!-- use this goal to weave all your test classes -->
                    </goals>
                </execution>
            </executions>
        </plugin>

3: then defined yourself runner:
    public class xxxxRunner implements Runner {

        @Override
        public Result exec(MethodSignature signature, Object[] args) {

        }
    }

4: mask your condition methods:

    @ConditionRun(xxxxRunner.class)
    public int Add1(int arg) {
        return ++arg;
    }


5: ok ,everything is done, run your build to make sure it works.