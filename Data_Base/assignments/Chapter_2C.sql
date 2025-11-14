-- 2.17
SELECT SKU, SKU_Description
FROM INVENTORY;

-- 2.18
SELECT SKU_Description, SKU
FROM INVENTORY;

-- 2.19
SELECT WarehouseID
FROM INVENTORY;

-- 2.20
SELECT DISTINCT WarehouseID
FROM INVENTORY;

-- 2.21
SELECT SKU, SKU_Description, WarehouseID, QuantityOnHand, QuantityOnOrder
FROM INVENTORY;

2.22
SELECT *
FROM INVENTORY;

-- 2.23
SELECT *
FROM INVENTORY
WHERE QuantityOnHand > 0;

-- 2.24
SELECT SKU, SKU_Description
FROM INVENTORY
WHERE QuantityOnHand = 0;

-- 2.25
SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE QuantityOnHand = 0
ORDER BY WarehouseID ASC;

-- 2.26
SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE QuantityOnHand > 0
ORDER BY WarehouseID DESC, SKU ASC;

2.27
SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE QuantityOnHand = 0
AND QuantityOnOrder > 0
ORDER BY WarehouseID DESC, SKU ASC;

-- 2.28
SELECT SKU, SKU_Description, WarehouseID
FROM INVENTORY
WHERE QuantityOnHand = 0
OR QuantityOnOrder = 0
ORDER BY WarehouseID DESC, SKU ASC;

-- 2.29
SELECT SKU, SKU_Description, WarehouseID, QuantityOnHand
FROM INVENTORY
WHERE QuantityOnHand > 1
AND QuantityOnHand < 10;

-- 2.30
SELECT SKU, SKU_Description, WarehouseID, QuantityOnHand
FROM INVENTORY
WHERE QuantityOnHand BETWEEN 2 AND 9;

-- 2.31
SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE SKU_Description LIKE 'Half-Dome%';

-- 2.32
SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE SKU_Description LIKE '%Climb%';

-- 2.33
SELECT DISTINCT SKU, SKU_Description
FROM INVENTORY
WHERE SKU_Description LIKE '__d%';

-- 2.34
select sum(QuantityOnHand) as TotalQuantiity,
COUNT(QuantityOnHand) as TotalNumber,
avg(QuantityOnHand) as AverageQuantity,
min(QuantityOnHand) as MinimumQuantity,
max(QuantityOnHand) as MaximumQuantity
from inventory;

select *,
sum(QuantityOnDemand) as totaliems,
update inventory as i warehouseID as w,
where QuantityOnHand < 0
group by warehouseID;

-- 2.35
-- THW DIFFERENCE BETWEEN COUNT AND SUM:
-- SUM(column) adds up all numeric values in the column.
-- COUNT(column) counts how many non-null rows the column contains.
-- SUM measures how much, COUNT measures how many.

-- 2.38
select warehouseid,
sum(QuantityOnHand) As Total
From inventory;

-- 2.40
SELECT I.SKU, I.SKU_Description,
W.WarehouseID,
W.WarehouseCity,
W.WarehouseState
FROM INVENTORY I
JOIN WAREHOUSE W 
ON I.WarehouseID = W.WarehouseID
WHERE W.WarehouseCity = 'Atlanta'
OR W.WarehouseCity = 'Bangor'
OR W.WarehouseCity = 'Chicago';

-- 2.42
SELECT SKU, SKU_Description, WarehouseID, WarehouseCity, WarehouseState
FROM WAREHOUSE NATURAL JOIN INVENTORY NATURAL JOIN SKU_DATA
WHERE WarehouseCity <> 'Atlanta'
AND WarehouseCity <> 'Bangor'
AND WarehouseCity <> 'Chicago';

-- 2.43
SELECT SKU, SKU_Description, WarehouseID, WarehouseCity, WarehouseState
FROM WAREHOUSE NATURAL JOIN INVENTORY NATURAL JOIN SKU_DATA
WHERE WarehouseCity NOT IN ('Atlanta', 'Bangor', 'Chicago');

-- 2.44
SELECT
SKU_Description or ' is located in ' or WarehouseCity AS ItemLocation
FROM SKU_DATA NATURAL JOIN INVENTORY NATURAL JOIN WAREHOUSE;

-- 2.45
SELECT 
SKU_Description or ' is located in ' or WarehouseCity AS ItemLocation
FROM SKU_DATA NATURAL JOIN INVENTORY NATURAL JOIN WAREHOUSE;

-- 2.46
SELECT I.SKU, S.SKU_Description, I.WarehouseID
FROM INVENTORY I, SKU_DATA S, WAREHOUSE W
WHERE I.SKU = S.SKU
AND I.WarehouseID = W.WarehouseIDAND W.Manager = 'Lucille Smith';

-- 2.47
SELECT I.SKU, S.SKU_Description, I.WarehouseID
FROM INVENTORY I
JOIN SKU_DATA S ON I.SKU = S.SKU
JOIN WAREHOUSE W ON I.WarehouseID = W.WarehouseID
WHERE W.Manager = 'Lucille Smith';

-- 2.48
SELECT WarehouseID,
AVG(QuantityOnHand) AS AvgQOH
FROM INVENTORY
WHERE WarehouseID IN (
    SELECT WarehouseID
    FROM WAREHOUSE
    WHERE Manager = 'Lucille Smith'
)
GROUP BY WarehouseID;

-- 2.49
SELECT I.WarehouseID,
AVG(I.QuantityOnHand) AS AvgQOH
FROM INVENTORY I, WAREHOUSE W
WHERE I.WarehouseID = W.WarehouseID
AND W.Manager = 'Lucille Smith'
GROUP BY I.WarehouseID;

-- 2.50
SELECT I.WarehouseID,
AVG(I.QuantityOnHand) AS AvgQOH
FROM INVENTORY I
JOIN WAREHOUSE W ON I.WarehouseID = W.WarehouseID
WHERE W.Manager = 'Lucille Smith'
GROUP BY I.WarehouseID;
