package com.example.lintchecks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

class SampleIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(SampleCodeDetector.ISSUE)
}