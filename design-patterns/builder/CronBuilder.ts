import { PeriodType } from "./PeriodType";

interface Builder<T> {
    build(): T;
}

export class CronBuilder implements Builder<string> {
    cronExperssion: string[] = Array<string>(5).fill('*');

    everyNth(n: number, periodType: PeriodType): CronBuilder {
        this.validateInput([n], periodType);
        this.cronExperssion[periodType] = `*/${n}`;

        return this;
    }

    onAllOf(ns: number[], periodType: PeriodType): CronBuilder {
        this.validateInput(ns, periodType);
        this.cronExperssion[periodType] = ns.join(',');

        return this;
    }

    on(n: number, periodType: PeriodType): CronBuilder {
        this.validateInput([n], periodType);
        this.cronExperssion[periodType] = `${n}`;

        return this;
    }

    build(): string {
        return this.cronExperssion.join(' ');
    }

    private validateInput(ns: number[], periodType: PeriodType): boolean {
        switch (periodType) {
            case PeriodType.Minute:
                if (ns.filter(n => n < 0 || n > 59).length > 0) {
                    throw new Error("Minutes must be between 0 and 59.");
                }
                break;
            case PeriodType.Hour:
                if (ns.filter(n => n < 0 || n > 23).length > 0) {
                    throw new Error("Hours must be between 0 and 23.");
                }
                break;
            case PeriodType.DayOfMonth:
                if (ns.filter(n => n < 1 || n > 31).length > 0) {
                    throw new Error("Days of the Month must be between 1 and 31.");
                }
                break;
            case PeriodType.Month:
                if (ns.filter(n => n < 1 || n > 12).length > 0) {
                    throw new Error("Months must be between 1 and 12.");
                }
                break;
            case PeriodType.DayOfWeek:
                if (ns.filter(n => n < 0 || n > 6).length > 0) {
                    throw new Error("Days of the Week must be between 0 and 6.");
                }
                break;
        }

        return true;
    }
}
