# (SELECT car_id FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE end_date < '2022-11-01 00:00:00') rental_history

SELECT car_id AS CAR_ID, discount_q.car_type AS CAR_TYPE,ROUND(daily_fee * (1-discount_rate * 0.01) * 30) as FEE 
FROM 
(   SELECT car_type, discount_rate 
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE duration_type = '30일 이상' and car_type IN ('세단','SUV')) discount_q
RIGHT JOIN 
( 
    SELECT *
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE car_id NOT IN (
    SELECT CAR_RENTAL_COMPANY_RENTAL_HISTORY.car_id 
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
        WHERE end_date >= '2022-11-01 00:00:00') AND car_type IN ('세단','SUV')
) CAR_RENTAL_COMPANY_CAR2
ON discount_q.car_type = CAR_RENTAL_COMPANY_CAR2.car_type
WHERE ROUND(daily_fee * (1-discount_rate * 0.01) * 30) >= 500000 
    AND ROUND(daily_fee * (1-discount_rate * 0.01) * 30) <2000000 
ORDER BY FEE DESC, car_type ASC, car_id DESC