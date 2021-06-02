package dev.jongho.membertest.arch;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import dev.jongho.membertest.Application;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

/**
 * 탐색 범위를 Application 전체로 하고, Test Class는 포함하지 않는다.
 */
@AnalyzeClasses(packagesOf = Application.class, importOptions = {ImportOption.DoNotIncludeTests.class})
public class ArchTests {

    /**
     * Api Controller는 Service에 접근해야 한다.
     */
    @ArchTest
    ArchRule apiClassRule = classes().that().haveSimpleNameEndingWith("Api")
            .should().accessClassesThat().haveSimpleNameEndingWith("Service");

    /**
     * Member로 시작하는 Class는 member package에 있어야 한다.
     */
    @ArchTest
    ArchRule memberClassRule = classes().that().haveSimpleNameStartingWith("Member")
            .should().resideInAPackage("..member..");

    /**
     * Repository는 Service에서만 접근해야 한다.
     */
    @ArchTest
    ArchRule repoClassRule = classes().that().haveSimpleNameEndingWith("Repository")
            .should().onlyHaveDependentClassesThat().haveSimpleNameEndingWith("Service");

    /**
     * 순환 참조가 없어야 한다.
     */
    @ArchTest
    ArchRule freeOfCycles = slices().matching("dev.jongho.membertest.(*)..")
            .should().beFreeOfCycles();
}
