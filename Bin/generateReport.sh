#!/bin/bash

REPORT_FILE="summary_report_$(date +'%Y-%m-%d').csv"

echo "Peak Hours" > $REPORT_FILE
mysql --login-path=local -D ParkingLotDB -e "
SELECT 
    MINUTE(checkInTime) AS minute,
    COUNT(*) AS TotalVehicles
FROM ParkingLot
GROUP BY MINUTE(checkInTime)
ORDER BY TotalVehicles DESC;" >> $REPORT_FILE


echo -e "\nAverage Parking Durations" >> $REPORT_FILE

mysql --login-path=local -D ParkingLotDB -e "
SELECT 
    spotID,
    ROUND(AVG(TIMESTAMPDIFF(SECOND, checkInTime, COALESCE(actualCheckOutTime, checkOutTime)))) AS AverageDurationInSeconds
FROM ParkingLot
GROUP BY spotID;" >> $REPORT_FILE


echo "$REPORT_FILE generated"
