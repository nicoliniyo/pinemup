package net.sourceforge.pinemup.ui.swing.tray;

import net.sourceforge.pinemup.core.CategoryChangedEvent;
import net.sourceforge.pinemup.core.CategoryChangedEventListener;
import net.sourceforge.pinemup.core.UserSettingsChangedEvent;
import net.sourceforge.pinemup.core.UserSettingsChangedEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrayMenuUpdater implements CategoryChangedEventListener, UserSettingsChangedEventListener {
   private static final Logger LOG = LoggerFactory.getLogger(TrayMenuUpdater.class);

   private TrayMenu trayMenu;

   public TrayMenuUpdater(TrayMenu trayMenu) {
      this.trayMenu = trayMenu;
   }

   @Override
   public void categoryChanged(CategoryChangedEvent event) {
      LOG.debug("Received CategoryChangedEvent.");
      trayMenu.createCategoriesMenu();
   }

   @Override
   public void settingsChanged(UserSettingsChangedEvent event) {
      trayMenu.initWithNewLanguage();
   }
}