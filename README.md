# Java Pmd Code Quality Check
Java Code Violations Check Using PMD
- Command For PMD run : mvn clean pmd:check pmd:cpd-check
- PMD Report : target/site/pmd.html
- In reports you can find violations details.
    -Note : you can exclude the specific package from your application for PMD check
    - add configuration inside the ruleset.xml
    - <exclude-pattern>.*/com/test/models/.*</exclude-pattern>

