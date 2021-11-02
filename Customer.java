package com.lbg.ep.customer.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lbg.ep.customer.common.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name="Customer")
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorFormula("case when CustomerId < 3 then 'VIP' else 'Customer' end")
public class Customer extends BaseEntity {

    @JsonProperty("OrgId")
//    @PrimaryKey(keyOrder = 1)
    @Column(name = "OrgId")
    private String orgId;

    @JsonProperty("CustomerId")
//    @PrimaryKey(keyOrder = 2)
    @Id
    @Column(name = "CustomerId")
    private String customerId;

    @JsonProperty("CustomerType")
    @Column(name = "CustomerType")
    private Long customerType;

    @JsonProperty("CustomerLifeCycle")
    @Column(name = "CustomerLifeCycle")
    private Long customerLifeCycle;

//    @NotMapped
    @Builder.Default
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "customerDetailModel")
    private CustomerDetail customerDetail = CustomerDetail.builder().build();

//    @NotMapped
    @Builder.Default
    @Transient
    private CompanyDetail companyDetail = CompanyDetail.builder().build();
//
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerModel")
    private List<Address> addresses;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerModel")
//    private List<ContactDetail> contactDetails;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerModel")
//    private List<CountryAssociation> countryAssociations;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerModel")
//    private List<SourceIdentifier> sourceIdentifiers;
//
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "relationshipCustomerModel")
    private List<CustomerRelationship> customerRelationShips;


    @Override public String toString() {
        return "Customer{" +
                "orgId='" + orgId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerType=" + customerType +
                ", customerLifeCycle=" + customerLifeCycle +
//                ", address=" + addresses +
//                ", CustomerRelationship=" + customerRelationShips +
                '}';
    }
}
