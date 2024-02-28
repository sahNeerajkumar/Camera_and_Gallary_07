/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package android.hardware.radio.network;
public class CellInfoNr implements android.os.Parcelable
{
  public android.hardware.radio.network.CellIdentityNr cellIdentityNr;
  public android.hardware.radio.network.NrSignalStrength signalStrengthNr;
  @Override
   public final int getStability() { return android.os.Parcelable.PARCELABLE_STABILITY_VINTF; }
  public static final android.os.Parcelable.Creator<CellInfoNr> CREATOR = new android.os.Parcelable.Creator<CellInfoNr>() {
    @Override
    public CellInfoNr createFromParcel(android.os.Parcel _aidl_source) {
      CellInfoNr _aidl_out = new CellInfoNr();
      _aidl_out.readFromParcel(_aidl_source);
      return _aidl_out;
    }
    @Override
    public CellInfoNr[] newArray(int _aidl_size) {
      return new CellInfoNr[_aidl_size];
    }
  };
  @Override public final void writeToParcel(android.os.Parcel _aidl_parcel, int _aidl_flag)
  {
    int _aidl_start_pos = _aidl_parcel.dataPosition();
    _aidl_parcel.writeInt(0);
    _aidl_parcel.writeTypedObject(cellIdentityNr, _aidl_flag);
    _aidl_parcel.writeTypedObject(signalStrengthNr, _aidl_flag);
    int _aidl_end_pos = _aidl_parcel.dataPosition();
    _aidl_parcel.setDataPosition(_aidl_start_pos);
    _aidl_parcel.writeInt(_aidl_end_pos - _aidl_start_pos);
    _aidl_parcel.setDataPosition(_aidl_end_pos);
  }
  public final void readFromParcel(android.os.Parcel _aidl_parcel)
  {
    int _aidl_start_pos = _aidl_parcel.dataPosition();
    int _aidl_parcelable_size = _aidl_parcel.readInt();
    try {
      if (_aidl_parcelable_size < 4) throw new android.os.BadParcelableException("Parcelable too small");;
      if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
      cellIdentityNr = _aidl_parcel.readTypedObject(android.hardware.radio.network.CellIdentityNr.CREATOR);
      if (_aidl_parcel.dataPosition() - _aidl_start_pos >= _aidl_parcelable_size) return;
      signalStrengthNr = _aidl_parcel.readTypedObject(android.hardware.radio.network.NrSignalStrength.CREATOR);
    } finally {
      if (_aidl_start_pos > (Integer.MAX_VALUE - _aidl_parcelable_size)) {
        throw new android.os.BadParcelableException("Overflow in the size of parcelable");
      }
      _aidl_parcel.setDataPosition(_aidl_start_pos + _aidl_parcelable_size);
    }
  }
  @Override
  public String toString() {
    java.util.StringJoiner _aidl_sj = new java.util.StringJoiner(", ", "{", "}");
    _aidl_sj.add("cellIdentityNr: " + (java.util.Objects.toString(cellIdentityNr)));
    _aidl_sj.add("signalStrengthNr: " + (java.util.Objects.toString(signalStrengthNr)));
    return "android.hardware.radio.network.CellInfoNr" + _aidl_sj.toString()  ;
  }
  @Override
  public int describeContents() {
    int _mask = 0;
    _mask |= describeContents(cellIdentityNr);
    _mask |= describeContents(signalStrengthNr);
    return _mask;
  }
  private int describeContents(Object _v) {
    if (_v == null) return 0;
    if (_v instanceof android.os.Parcelable) {
      return ((android.os.Parcelable) _v).describeContents();
    }
    return 0;
  }
}
