This is an Android demo application for Creating a ToDo App.
Time spent: 5 hours.
It allows the user to:
1. Add an item to the to-do list displayed.
2. Remove an item.
3. Edit the item. A new screen activity will be displayed for editing the item.
The original to do list is updated after the new activity edits the item and sends it back via intent.

This is an Android demo application for Creating a ToDo App.

ToDoApp is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Prerna Manaktala

Time spent: 5 hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ] User can **successfully add and remove items** from the todo list
* [ ] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [ ] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are being implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features will be implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/nYMHJnz.gif' title='Video Walkthrough' width='600' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

I have not used any other platform for app development.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

Function of Adapter in android:
An Adapter object acts as a bridge between an AdapterView which is a listview in our case and the underlying data which is a list of items here for that view. The Adapter provides access to the items created. The Adapter is also responsible for making a View for each item in the data set.
Purpose of convertView:
When a ListView uses an Adapter to fill its rows with Views, the adapter populates each list item with a View object by calling getView() on each row. The Adapter uses the convertView as a way of recycling old View objects that are no longer being used. In this way, the ListView can send the Adapter old, "recycled" view objects that are no longer being displayed instead of instantiating an entirely new object each time the Adapter wants to display a new list item. This is the purpose of the convertView parameter.

## Notes
Faced these challanges while building the app:
1. How to use click listeners.
2. How to use pass data back to the main activity.

## License

    Copyright [2017] [Prerna Manaktala]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
