
What kind of decision making have you done?
- Take a recent example, budgeting and serving communicates with throttle rate as the signal to dictate how frequently a campaign should be throttled.
- We found some campaigns throttle many times in the day, but they ended up with underspend
- The serving science team proposed a solution to "soft-throttle", which means they may still spend if the throttle signal is for the hour.

- There are many ways to support this, but before supporting this feature, we also evaluated that the two system will become strongly coupled.
-- Earlier, whether the campaign is properly throttled is decided at budgeting system, now, it has to be decided/or debugged by both.
-- But indeed, if their proposed algorithm really can make money, we may need to compromise.

- Next, how to support the feature?
- We could either send percentage of spend along with the throttle rate, or could just send less signals.

