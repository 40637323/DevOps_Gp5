# Use Case 12
The top N populated cities in the world where N is provided by the user.
## CHARACTERISTIC INFORMATION
### Goal in Context
As an analyst, I want to receive a list of the top 7 populated cities in the world so that I can focus on the most populated cities in the world.
### Scope
Organization black box
### Level
User goals
### Preconditions
The system connected to the database successfully.
### Success End Condition
The analyst will generate a report for the top 7 populated cities in the world just as the organization’s request.
### Failed End Condition
The system generates an error message behind "Error Executing Query" term.
### Primary Actor
Analyst
### Trigger
An organization will make a request to get the report of the top 7 populated cities in the world. 
### Main Success Scenario
4.  The analyst request to generate report for the top 7 populated cities in the world.
5.  The system extracts the population data for the top 7 cities in the world.
6.  The system shows a clear and readable list of top 7 populated cities in the world. 
### Extensions
In Step 1, the analyst failure to request the report.
In Step 2, The system failed to extracts the population data and generate an error message.
### Sub-Variations
None
### SCHEDULE
Due Date: 9.2.2024
