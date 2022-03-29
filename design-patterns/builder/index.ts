import { CronBuilder } from "./CronBuilder";
import { PeriodType } from "./PeriodType";

const cronBuilder = new CronBuilder();
cronBuilder.everyNth(31, PeriodType.Minute);
cronBuilder.everyNth(2, PeriodType.Month);
console.log(cronBuilder.build());
