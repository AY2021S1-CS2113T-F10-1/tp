# User Guide

## Introduction

HdBuy allows you to easily find and bookmark resale flats available matching your preference.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Down the latest version of `HdBuy` from [here](https://github.com/AY2021S2-CS2113-F10-1/tp/releases/tag/v0.1).

## Features 

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `remove INDEX`, `INDEX` is a parameter which can be used as `remove 1`.
  e.g. in `filter ATTRIBUTE VALUE`, `ATTRIBUTE` is the attribute of a unit to filter. `VALUE` is the value of the attribute.

</div>

### View Shortlist : `shortlist`

Shows all units in the shortlist.

Format: `shortlist`

### Append to shortlist: `save`

Adds a unit to the shortlist.

Format: `save INDEX​`

<div markdown="span" class="alert alert-primary">:bulb: **Note:**
You have to complete a search before saving a unit to shortlist.
Only indexes shown in search results are valid.
</div>

Example:
* `save 1` to save the first unit in search result.

### Remove from shortlist: `remove`

Removes a unit from the shortlist.

Format: `remove INDEX​`

<div markdown="span" class="alert alert-primary">:bulb: **Note:**
You have to have at least 1 unit in shortlist.
Only indexes shown in shortlist are valid.
</div>

Example:
* `remove 1` to remove the first unit in shortlist.

### List filter conditions: `list`

Shows all currently set filter condition to filter units matching preferences.

Format: `list`

### Clear filter conditions: `clear`

Removes all currently set filter conditions.

Format: `clear`

## FAQ

**Q**: How do I transfer my data (shortlisted units) to another computer? 

**A**: Install the app in the other computer and copy the current 'shortlist.txt' file into the same directory as the app.

## Command Summary

Action | Format
--------|----------------------------------------
**View Shortlist** | `shortlist`
**Save Shortlist** | `save INDEX` eg: `save 1`
**Remove Shortlist** | `remove INDEX` eg: `remove 1`
**Add a filter condition** | `filter ATTRIBUTE VALUE` eg: `filter location woodlands`
**Show filter conditions** | `list`
**Clear filter conditions** | `clear`
**Search for units** | `find`
**Displays help guide** | `help`
**Sort search results by ascending price** | `sort asc`
**Sort search results by descending price** | `sort desc`

