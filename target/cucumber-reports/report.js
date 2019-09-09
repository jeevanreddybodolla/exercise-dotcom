$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Values.feature");
formatter.feature({
  "name": "Verifies values on the https://www.exercise1.com/values web page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify the values on the page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ValidateValues"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on https://www.exercise1.com/values page",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.iAmOnValuesPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The right count of values should appear on the screen",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.verifyTheCountOfValues()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The values on the screen should be greater than 0",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verifyTheValuesAreGreaterThanZero()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The total balance should be correct based on the values listed on the screen",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verifyTheTotalBalance()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The values should be formatted as currencies",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verifyTheValuesAreFormatted()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The total balance should match the sum of the values",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.verifyTheTotalBalance2()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});