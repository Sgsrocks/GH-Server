package godzhell.cache.map;

import java.io.IOException;
import java.nio.ByteBuffer;

import godzhell.cache.Cache;
import godzhell.cache.index.impl.MapIndex;
import godzhell.cache.object.CacheObject;
import godzhell.cache.object.GameObjectData;
import godzhell.cache.util.ByteBufferUtils;
import godzhell.cache.util.ZipUtils;
import godzhell.clip.ObjectDef;
import godzhell.model.players.Position;

/**
 * A class which parses landscape files and fires events to a listener class.
 * 
 * @author Graham Edgecombe
 * 
 */
public class LandscapeParser {

	/**
	 * The cache.
	 */
	private Cache cache;

	/**
	 * The cache file.
	 */
	private int area;

	/**
	 * The listener.
	 */
	private LandscapeListener listener;

	/**
	 * Creates the parser.
	 * 
	 * @param cache
	 *            The cache.
	 * @param area
	 *            The area id.
	 * @param listener
	 *            The listener.
	 */
	public LandscapeParser(Cache cache, int area, LandscapeListener listener) {
		this.cache = cache;
		this.area = area;
		this.listener = listener;
	}

	/**
	 * Parses the landscape file.
	 * 
	 * @throws java.io.IOException
	 *             if an I/O error occurs.
	 */
	public void parse() throws IOException {
		int x = (area >> 8 & 0xFF) * 64;
		int y = (area & 0xFF) * 64;

		MapIndex index = cache.getIndexTable().getMapIndex(area);

		ByteBuffer buf = ZipUtils.unzip(cache.getFile(4, index.getLandscapeFile()));
		int objId = -1;
		while (true) {
			int objIdOffset = ByteBufferUtils.getUIncrementalSmart(buf);
			if (objIdOffset == 0) {
				break;
			} else {
				objId += objIdOffset;
				int objPosInfo = 0;
				while (true) {
					int objPosInfoOffset = ByteBufferUtils.getSmart(buf);
					//System.out.println(objPosInfoOffset);
					if (objPosInfoOffset == 0) {
						break;
					} else {
						objPosInfo += objPosInfoOffset - 1;

						int localX = objPosInfo >> 6 & 0x3f;
						int localY = objPosInfo & 0x3f;
						int plane = objPosInfo >> 12;

						int objOtherInfo = buf.get() & 0xFF;

						int type = objOtherInfo >> 2;
						int rotation = objOtherInfo & 3;

						Position loc = new Position(localX + x, localY + y, plane);

						listener.objectParsed(new CacheObject(GameObjectData.forId(objId), loc, type, rotation));
					}
				}
			}
		}
	}

}
