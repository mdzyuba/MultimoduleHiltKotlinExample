package com.example.lintchecks

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

class SampleCodeDetector: Detector(), Detector.UastScanner {
    override fun getApplicableMethodNames(): List<String>? = listOf("onCreate")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        context.report(ISSUE, node, context.getLocation(node),
            "This is an onCreate check`: **Congratulations**")
    }

    companion object {
        /** Issue describing the problem and pointing to the detector implementation */
        @JvmField
        val ISSUE: Issue = Issue.create(
            // ID: used in @SuppressLint warnings etc
            id = "OnCreateMethodId",
            // Title -- shown in the IDE's preference dialog, as category headers in the
            // Analysis results window, etc
            briefDescription = "The onCreate is overridden",
            // Full explanation of the issue; you can use some markdown markup such as
            // `monospace`, *italic*, and **bold**.
            explanation = """
                    A sample lint check
                    """, // no need to .trimIndent(), lint does that automatically
            category = Category.CORRECTNESS,
            priority = 6,
            severity = Severity.WARNING,
            implementation = Implementation(
                SampleCodeDetector::class.java,
                Scope.JAVA_FILE_SCOPE)
        )
    }
}