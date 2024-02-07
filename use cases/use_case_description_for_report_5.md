# Use Case 5
The top N populated countries in a continent where N is provided by the user.
## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want to view the top 7 populated countries in a continent so that I can easily access the related population information.
### Scope
Organization black box
### Level
User goals
### Preconditions
The system connected to the database successfully.
### Success End Condition
The analyst will generate a report for the top 7 populated countries in a continent just as the organization’s request.
### Failed End Condition
The system generates an error message behind "Error Executing Query" term.
### Primary Actor
Analyst
### Trigger
An organization will make a request to get the report of the top 7 populated countries in the continent. 
### Main Success Scenario
1.  The analyst request to generate report for the top 7 populated countries in the continent.
2.  The system extracts the population data for the top 7 countries in the continent.
3.  The system shows a clear and readable list of top 7 populated countries in the continent. 
### Extensions
In Step 1, the analyst failure to request the report.
In Step 2, The system failed to extracts the population data and generate an error message.
### Sub-Variations
None
### SCHEDULE
Due Date 9.2.2024
