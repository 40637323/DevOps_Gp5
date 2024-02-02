# Use Case 6
The top N populated countries in a region where N is provided by the user.
## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want to list the top 7 populated countries in a region so that I can easily access the related population information.
### Scope
Organization black box
### Level
User goals
### Preconditions
The system will connect the World database successfully.
### Success End Condition
The analyst will generate a report for the top 7 populated countries in a region just as the organization’s request.
### Failed End Condition
The system generating the top 7 populated countries in a region as an empty list.
### Primary Actor
Analyst
### Trigger
An organization will make a request to get the report of the top 7 populated countries in the region. 
### Main Success Scenario
1.  The analyst request to generate report for the top 7 populated countries in the region.
2.  The system extracts the population data for the top 7 countries in the region.
3.  The system shows a clear and readable list of top 7 populated countries in the region. 
### Extensions
In Step 1, the analyst failure to request the report.
In Step 2, The system failed to extracts the population data and generate empty list.
### Sub-Variations
None
### SCHEDULE
Due Date: 9.2.2024
