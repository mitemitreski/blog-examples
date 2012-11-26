#include <libnotify/notify.h>

void main () {
  notify_init ("Hello world!");
  NotifyNotification * Hello = notify_notification_new (
  	"Hello world", "This is an example notification.", "dialog-information");
  notify_notification_show (Hello, NULL);
  notify_notification_update (Hello,"novo","nov tekst","dialog-information");
  notify_notification_show (Hello, NULL);
  
}
