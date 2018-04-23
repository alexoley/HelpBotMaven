package telegram.fit;

import com.google.common.annotations.VisibleForTesting;
import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;
import org.telegram.abilitybots.api.db.*;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Locality.USER;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class HelpBot extends AbilityBot {
    public static final String BOT_TOKEN = System.getenv("BOT_TOKEN");
    public static final String BOT_USERNAME = System.getenv("BOT_USERNAME");
    public static final int BOT_CREATOR_ID = Integer.parseInt(System.getenv("BOT_CREATOR_ID"));

    public HelpBot() {
        super(BOT_TOKEN, BOT_USERNAME);
    }

    @Override
    public int creatorId() {
        return BOT_CREATOR_ID;
    }

    public Ability tomorrowShedule() {
        return Ability.builder()
                .name("tomorrowshedule")
                .info("Show tomorrow shedule")
                .privacy(PUBLIC)
                .locality(ALL)
                .action(ctx -> silent.send(Shedule.printClasses(1), ctx.chatId()))
                .build();
    }

    public Ability todayShedule() {
        return Ability.builder()
                .name("todayshedule")
                .info("Show today shedule")
                .privacy(PUBLIC)
                .locality(ALL)
                .action(ctx -> silent.send(Shedule.printClasses(0), ctx.chatId()))
                .build();
    }

    public Ability weekParity() {
        String message = String.format("Сейчас %d(%s) неделя",
                WeekParity.numberOfWeeks(0),
                WeekParity.isOdd(WeekParity.numberOfWeeks(0)));
        return Ability.builder()
                .name("weekparity")
                .info("Show week parity")
                .privacy(PUBLIC)
                .locality(ALL)
                .action(ctx -> silent.send(message, ctx.chatId()))
                .build();
    }

    public Ability roPollard() {
        return Ability.builder()
                .name("ro")
                .info("arguments x g p")
                .privacy(PUBLIC)
                .locality(USER)
                .input(3)
                .action(ctx -> silent.send(RoPollard.getResult(
                        ctx.firstArg(),
                        ctx.secondArg(),
                        ctx.thirdArg()),
                        ctx.chatId()))
                .build();
    }
}
