#!/bin/bash

# How To Set Up:
#   mysql provides a utility called mysql_config_editor to set up a login path that stores authentication credentials securely. 
#   The credentials are stored in an encrypted file named .mylogin.cnf in the user's home directory. 
#       mysql_config_editor set --login-path=local --host=localhost --user=testuser --password

watch -n 1 '
mysql --login-path=local -D ParkingLotDB --table -e "
SELECT
  ticketId,
  spotID,
  vehiclePlate,
  DATE_FORMAT(checkInTime, '\''%H:%i:%s'\'') AS checkInTime,
  DATE_FORMAT(checkOutTime, '\''%H:%i:%s'\'') AS checkOutTime,
  DATE_FORMAT(actualCheckOutTime, '\''%H:%i:%s'\'') AS actualCheckOutTime
FROM ParkingLot
ORDER BY ticketId DESC;
"
'