package org.gildedrose;

public class QualityControlFactory {
	
	public static final String BACKSTAGE_PASS_ITEM_NAME = "Backstage passes to a TAFKAL80ETC concert";
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

	private static enum ItemQualityControl {
		BACKSTAGE_PASS(BACKSTAGE_PASS_ITEM_NAME, new BackstagePassQualityControl()),
		SULFURAS(SULFURAS_HAND_OF_RAGNAROS, new SulfurasQualityControl());
		
		private String itemName;
		private QualityControl qualityControl;

		private ItemQualityControl(String itemName, QualityControl qualityControl) {
			this.itemName = itemName;
			this.qualityControl = qualityControl;
		}
		
		public static QualityControl qualityControlFor(Item item) {
			for (ItemQualityControl itemQualityControl : ItemQualityControl.values()) {
				if (itemQualityControl.itemName.equals(item.getName())) {
					return itemQualityControl.qualityControl;
				}
			}
			return new DefaultQualityControl();
		}
	}
	
	public QualityControl qualityControlFor(Item item) {
		return ItemQualityControl.qualityControlFor(item);
	}

}
