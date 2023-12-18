-- 코드를 입력하세요


-- SELECT CR.CAR_ID



SELECT EXTRACT(MONTH FROM START_DATE) MONTH, CAR_ID, COUNT(*) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE START_DATE BETWEEN TO_DATE('2022-08-01', 'YYYY-MM-DD') AND TO_DATE('2022-10-31', 'YYYY-MM-DD')
AND CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN TO_DATE('2022-08-01', 'YYYY-MM-DD') AND TO_DATE('2022-10-31', 'YYYY-MM-DD')
    GROUP BY CAR_ID
    HAVING COUNT(*) >=5
)
GROUP BY EXTRACT(MONTH FROM START_DATE),CAR_ID
HAVING COUNT(*) > 0
ORDER BY MONTH, CAR_ID DESC

-- SELECT EXTRACT(MONTH FROM CRCRH_T.START_DATE) MONTH, CRCRH_T.CAR_ID, COUNT(*) RECORDS
-- FROM (SELECT CAR_ID
--      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
--      WHERE TO_CHAR(START_DATE, 'YYYY-MM') BETWEEN '2022-08' AND '2022-10'
--      GROUP BY CAR_ID
--      HAVING COUNT(*) >= 5) CRCRH,
--      CAR_RENTAL_COMPANY_RENTAL_HISTORY CRCRH_T
-- WHERE CRCRH_T.CAR_ID = CRCRH.CAR_ID AND
-- TO_CHAR(CRCRH_T.START_DATE, 'YYYY-MM') BETWEEN '2022-08' AND '2022-10'
-- GROUP BY EXTRACT(MONTH FROM CRCRH_T.START_DATE), CRCRH_T.CAR_ID
-- HAVING COUNT(*) > 0
-- ORDER BY EXTRACT(MONTH FROM CRCRH_T.START_DATE), CRCRH_T.CAR_ID DESC

