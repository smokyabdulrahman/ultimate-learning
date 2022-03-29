# Cron jobs builder
## What is the input?
- Start time: DD/MM/YYYY HOUR:MINUTE
- Frequency:
  - Fixed enum for now:
    - Every (VALUE: number) (VALUE_TYPE: TimeType)

## What the builder will do when build() is called?
- Assuming that configuration is overridden.
- Build Cron string based on configuration given.

## What is the output?
- Cron job string

```
# ┌───────────── minute (0 - 59)
# │ ┌───────────── hour (0 - 23)
# │ │ ┌───────────── day of the month (1 - 31)
# │ │ │ ┌───────────── month (1 - 12)
# │ │ │ │ ┌───────────── day of the week (0 - 6) (Sunday to Saturday;
# │ │ │ │ │                                   7 is also Sunday on some systems)
# │ │ │ │ │
# │ │ │ │ │
# * * * * * <command to execute>
```
