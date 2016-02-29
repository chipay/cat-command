package org.chipay.cat.commands;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CatBannerProvider extends DefaultBannerProvider  {

    public String getBanner() {
        StringBuffer buf = new StringBuffer();
        buf.append("                                      ___" + OsUtils.LINE_SEPARATOR);
        buf.append("             |\\__/,|   (`\\        _.-|   |          |\\__/,|   (`\\"+ OsUtils.LINE_SEPARATOR);
        buf.append("             |o o  |__ _) )      {   |   |          |o o  |__ _) )"+ OsUtils.LINE_SEPARATOR);
        buf.append("           _.( T   )  `  /        \"-.|___|        _.( T   )  `  /"+ OsUtils.LINE_SEPARATOR);
        buf.append("n n._    ((_ `^--' /_<  \\         .--'-`-.     _((_ `^--' /_<  \\"+ OsUtils.LINE_SEPARATOR);
        buf.append("<\" _ }=- `` `-'(((/  (((/       .+|______|__.-||__)`-'(((/  (((/"+ OsUtils.LINE_SEPARATOR);
        buf.append("Version:" + this.getVersion());
        return buf.toString();

    }

    public String getVersion() {
        return "1.0.0";
    }

    public String getWelcomeMessage() {
        return "Welcome to Cat CLI";
    }

    @Override
    public String getProviderName() {
        return "Cat Banner";
    }
}