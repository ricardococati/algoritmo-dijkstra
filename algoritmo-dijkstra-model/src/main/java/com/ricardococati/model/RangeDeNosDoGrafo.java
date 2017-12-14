package com.ricardococati.model;

/**
 * Created by joao on 14/12/17.
 */
public class RangeDeNosDoGrafo {

    private String rangePrimeiroNoh;
    private String rangeSegundoNoh;

    public RangeDeNosDoGrafo() {
        super();
    }

    public String getRangePrimeiroNoh() {
        return rangePrimeiroNoh;
    }

    public void setRangePrimeiroNoh(String rangePrimeiroNoh) {
        this.rangePrimeiroNoh = rangePrimeiroNoh;
    }

    public String getRangeSegundoNoh() {
        return rangeSegundoNoh;
    }

    public void setRangeSegundoNoh(String rangeSegundoNoh) {
        this.rangeSegundoNoh = rangeSegundoNoh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RangeDeNosDoGrafo that = (RangeDeNosDoGrafo) o;

        if (rangePrimeiroNoh != null ? !rangePrimeiroNoh.equals(that.rangePrimeiroNoh) : that.rangePrimeiroNoh != null)
            return false;
        return rangeSegundoNoh != null ? rangeSegundoNoh.equals(that.rangeSegundoNoh) : that.rangeSegundoNoh == null;
    }

    @Override
    public int hashCode() {
        int result = rangePrimeiroNoh != null ? rangePrimeiroNoh.hashCode() : 0;
        result = 31 * result + (rangeSegundoNoh != null ? rangeSegundoNoh.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RangeDeNosDoGrafo{" +
                "rangePrimeiroNoh='" + rangePrimeiroNoh + '\'' +
                ", rangeSegundoNoh='" + rangeSegundoNoh + '\'' +
                '}';
    }
}
