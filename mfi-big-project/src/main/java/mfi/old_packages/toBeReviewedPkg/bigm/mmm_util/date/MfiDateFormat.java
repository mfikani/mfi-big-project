package mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.date;

import mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.MfiConstants;

/**
 * Exemple d'utilisation:
 * <pre>
 *     String ddMMyyyyDate = DateFormat.format(new Date(), DateFormat.DDMMYYYY);
 *     String yyyyMMddDate = DateFormat.format(new Date(), DateFormat.YYYYMMDD);
 * </pre>
 * @author mfi
 *
 */
public final class MfiDateFormat extends MfiConstants
{
	public static final String DD_MM_YYYY = "dd.MM.yyyy";
	
	public static final String full_date = "yyyy/MM/dd HH:mm:ss";
}
