Given an item named <name>, with sell in <sellIn> days and quality <quality>
When the quality of the item is updated after one day
Then sell in should be <newSellIn>
And quality should be <newQuality>

Examples:
| name                                      | sellIn | quality | newSellIn | newQuality |
| +5 Dexterity Vest                         |     10 |      10 |         9 |          9 |  
| +5 Dexterity Vest                         |     -1 |      10 |        -2 |          8 |
| +5 Dexterity Vest                         |     10 |       0 |         9 |          0 |
| +5 Dexterity Vest                         |     -1 |       1 |        -2 |          0 |
| Aged Brie                                 |     20 |      10 |        19 |         11 |
| Aged Brie                                 |     20 |      50 |        19 |         50 |
| Sulfuras, Hand of Ragnaros                |     10 |      20 |        10 |         20 |
| Backstage passes to a TAFKAL80ETC concert |     10 |      20 |         9 |         22 |
| Backstage passes to a TAFKAL80ETC concert |      5 |      20 |         4 |         23 |
| Backstage passes to a TAFKAL80ETC concert |      5 |      49 |         4 |         50 |
| Backstage passes to a TAFKAL80ETC concert |      0 |      20 |        -1 |          0 |
| Conjured Mana Cake                        |     10 |      20 |         9 |         18 |
| Conjured Mana Cake                        |     10 |       1 |         9 |          0 |