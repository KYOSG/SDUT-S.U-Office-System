package com.sdut.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 借用登记表
 *
 * @TableName borrow_info
 */
@TableName(value = "borrow_info")
@Data
public class BorrowInfo implements Serializable {
    /**
     * 借用编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 借用人ID
     */
    private String userId;

    /**
     * 借用日期
     */
    private String borrowDate;

    /**
     * 归还日期（确认归还后自动设置）
     */
    private String returnDate;

    /**
     * 借用信息
     */
    private String information;

    /**
     * 状态（0待审核，2未通过，1待归还，3已归还）
     */
    private String state;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BorrowInfo other = (BorrowInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getBorrowDate() == null ? other.getBorrowDate() == null : this.getBorrowDate().equals(other.getBorrowDate()))
                && (this.getReturnDate() == null ? other.getReturnDate() == null : this.getReturnDate().equals(other.getReturnDate()))
                && (this.getInformation() == null ? other.getInformation() == null : this.getInformation().equals(other.getInformation()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getBorrowDate() == null) ? 0 : getBorrowDate().hashCode());
        result = prime * result + ((getReturnDate() == null) ? 0 : getReturnDate().hashCode());
        result = prime * result + ((getInformation() == null) ? 0 : getInformation().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", borrowDate=").append(borrowDate);
        sb.append(", returnDate=").append(returnDate);
        sb.append(", information=").append(information);
        sb.append(", state=").append(state);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}