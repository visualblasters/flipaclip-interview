# Welcome!
Please follow the steps below to get started.

## Steps
1. Clone the project into your machine.
2. Run the android app to make sure it starts up (it should load an activity with a single button in the middle).
3. Implement the changes asked for in this README file.
4. Once you are ready, create a PR and submit it.

## Project 
### Goal
Create a screen that displays a list of brushes and allows you to change the size of each.
A rough wireframe would look like this:

<img width="400" alt="Screenshot 2023-01-30 at 12 05 45 PM" src="https://user-images.githubusercontent.com/374079/215872901-733750bb-44e5-4091-ad18-be06ad519a3a.png">

### Requirements
1. BrushesFragment: responsible for displaying a list of available brushes and highlighting the currently selected brush. 
2. Tapping on a non selected brush, simply selects it.
3. Tapping the selected brush opens the BrushSettingsFragment.
4. BrushSettingsFragment: responsible for allowing you to set the size via a slider (range should be 1-100).
5. In the HomeActivity there is a method called "onShowBrushes". Tapping this button should display the BrushesFragment.
6. Use the provided class BrushRepository to access the data.

### Notes
1. Do not worry about the UI design, just keep it simple and straightforward. 
2. Do not worry about persisting the data, just use the provided BrushRepository class.
