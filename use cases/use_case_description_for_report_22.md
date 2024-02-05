# Use-Case 22
The top N populated capital cities in a region where N is provided by the user.
## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want to see the report related to the top populated countries in a region where I want to choose the number of countries "n" to view so that I can easily access the related population information.
### Scope
Organization black box
### Level
User goals
### Preconditions
The system will connect the database successfully.
### Success End Condition
The analyst will generate a report for the top 7 populated capital cities in a region as the organization’s request.
### Failed End Condition
The generated top 7 populated capital cities in a region as an error message.
### Primary Actor
Analyst
### Trigger
An organization will make a request to get the report of the top 7 populated capital cities in a region. 
### Main Success Scenario
1.  The analyst request to generate report for the top 7 populated capital cities in a region.
2.  The system extracts the population data for the top 7 capital cities in a region.
3.  The system shows a clear and readable list of top 7 populated capital cities in a region. 
### Extensions
In Step 2, The system failed to extract the population data and generate an error message.
### Sub-Variations
None
### SCHEDULE
Due Date:16.2.2024
